package com.example.dz2.ui.first

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.dz2.R
import com.example.dz2.core.BaseFragment
import com.example.dz2.data.local.TaskModel
import com.example.dz2.databinding.FragmentFirstBinding
import com.example.dz2.ui.second.SecondFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {

    private lateinit var adapter: TaskAdapter
    private lateinit var viewModel: FirstViewModel

    override fun inflateViewBinding(): FragmentFirstBinding {
        return FragmentFirstBinding.inflate(layoutInflater)
    }

    override fun initView() {
        adapter = TaskAdapter(this::deleteClick, this::onClick, this::onClickOnCheckBox)
        binding.recyclerView.adapter = adapter
        viewModel = ViewModelProvider(requireActivity())[FirstViewModel::class.java]
        setData()
        binding.btnFab.setOnClickListener {
            replaceActivity()
        }
    }

    private fun onClickOnCheckBox(taskModel: TaskModel) {
        viewModel.updateData(taskModel)
        setData()
    }

    private fun replaceActivity() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, SecondFragment()).commit()
    }

    private fun setData() {
        val list = viewModel.getData()
        for (task in list) {
            if (task.check == true) {
                adapter.addTrueCheckBox(task) // Добавляем элементы с true checkBox в начало списка
            }
        }
        adapter.addData(list)
    }

    private fun onClick(taskModel: TaskModel) {
        setData()
    }

    private fun deleteClick(taskModel: TaskModel) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete?")
        builder.setMessage("Delete sure")
        builder.setPositiveButton("Delete") { d, _ ->
            viewModel.deleteData(taskModel)
            setData()
            d.dismiss()
        }
        builder.setNegativeButton("No") { d, _ ->
            d.dismiss()
        }
        builder.create().show()
    }
}
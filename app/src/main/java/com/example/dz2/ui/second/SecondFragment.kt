package com.example.dz2.ui.second

import androidx.lifecycle.ViewModelProvider
import com.example.dz2.R
import com.example.dz2.core.BaseFragment
import com.example.dz2.data.local.TaskModel
import com.example.dz2.databinding.FragmentSecondBinding
import com.example.dz2.ui.first.FirstFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_first) {
    override fun inflateViewBinding(): FragmentSecondBinding {
        return FragmentSecondBinding.inflate(layoutInflater)
    }

  private val viewModel: SecondViewModel by lazy {
    ViewModelProvider(requireActivity())[SecondViewModel::class.java] }

  override fun initView() {
    binding.btnSave.setOnClickListener {
      val result = TaskModel(
        title = binding.etFirst.text.toString(),
        desc = binding.etSecond.text.toString()
      )
      viewModel.insertData(result)
      requireActivity().supportFragmentManager.beginTransaction()
        .replace(R.id.container, FirstFragment()).commit()
    }
  }
}
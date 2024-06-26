package com.example.a160421129_studentapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160421129_studentapp.R
import com.example.a160421129_studentapp.databinding.StudentListItemBinding
import com.example.a160421129_studentapp.model.Student
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class StudentListAdapter(val studentList: ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(),
    ButtonDetailClickListener{

    class StudentViewHolder(var view: StudentListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
//        val binding = StudentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return StudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studentList[position]
        holder.view.listener = this
//        holder.binding.txtId.text = studentList[position].id
//        holder.binding.txtName.text = studentList[position].name
//
//        holder.binding.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionDetailFragment(studentList[position].id.toString())
//            Navigation.findNavController(it).navigate(action)
//        }

//        val picasso = Picasso.Builder(holder.itemView.context)
//        picasso.listener {
//                picasso, uri, exception -> exception.printStackTrace()
//        }
//        picasso.build().load(
//            studentList[position].photoUrl).into(holder.binding.imgStudent, object :Callback{
//
//            override fun onSuccess() {
//                holder.binding.progressImage.visibility = View.INVISIBLE
//                holder.binding.imgStudent.visibility = View.VISIBLE
//            }
//
//            override fun onError(e: Exception?) {
//                Log.d("Cek", "Error")
//            }
//        })
    }


    fun updateStudentList(newStudentList: ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionDetailFragment(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}
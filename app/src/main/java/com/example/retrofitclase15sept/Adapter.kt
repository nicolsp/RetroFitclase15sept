package com.example.retrofitclase15sept

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitclase15sept.Model.Terrain
import kotlinx.android.synthetic.main.item_list_view.view.*

class Adapter(var mpassMars: Mars): RecyclerView.Adapter<Adapter.TaskViewHolder>() { //PASO 4 M IMPLEMENTAR RECYCLER

    private var dataList = emptyList<Terrain>()  //PASO 1

    fun updateListMars(mDataList: List<Terrain>) { // PASO 2

        dataList = mDataList
       // notifyDataSetChandeg()
    }

    //PASO 3
    inner class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val ingTerrain = itemView.iV
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {
            mpassMars.passMars(dataList[adapterPosition])
        }

    }
// ESTO APARECIO DESPUES DEL PASO 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder { // PASO 4.1
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view,parent , false )
        return TaskViewHolder(itemView)
    }
//
    override fun getItemCount() = dataList.size  //PASO 4.3



    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) { // PASO 4.2
        val mTerrain: Terrain = dataList[position]
            Glide.with(holder.itemView.context).load(mTerrain.imgSrc).into(holder.ingTerrain)



    }
    interface Mars {
        fun passMars(mTerrain: Terrain)
    }
}








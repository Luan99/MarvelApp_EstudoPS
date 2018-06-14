package com.oliveira.luan78912.marvelapp.Adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.oliveira.luan78912.marvelapp.Model.personagem
import com.oliveira.luan78912.marvelapp.R
import kotlinx.android.synthetic.main.activity_lista.view.*
import kotlinx.android.synthetic.main.meus_herois_item.view.*

class heroipersonagem(private val personagem: List<personagem>,
                      private val context: Context,
                      val listener: (personagem) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position:Int){
        val note = personagem[position]
        holder.let{
            holder.bindView(note, listener)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.meus_herois_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personagem.size
    }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
      fun bindView (personagem: personagem,
                   listener: (personagem) -> Unit) = with(itemView){

          val titulo: String
          val descricao: String
          ivHeroi.setImageDrawable(ContextCompat.getDrawable(context, personagem.resourceId))
          tvNome.text = personagem.titulo

          tvDescricao.text = personagem.descricao
          setOnClickListener {listener(personagem)}
      }
  }
  interface ClickListener{
      fun onClick(view: View,position: Int)
  }
}


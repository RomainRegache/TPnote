package com.example.tpnote.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tpnote.databinding.ItemLigneBinding
import com.example.tpnote.model.Match

class HistoriqueAdapteur(private var historiqueList: ArrayList<Match>, private val context: Context)
    : RecyclerView.Adapter<HistoriqueAdapteur.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLigneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return (
                ViewHolder(binding)
                )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ligne: Match = historiqueList[position]

        holder.binding.joueurs.text = "${ligne.joueur1} - ${ligne.joueur2}"
        holder.binding.score.text = ligne.listScore?.let { scoreToString(it) }

        //holder.idView.setOnClickListener()
    }

    override fun getItemCount(): Int = historiqueList.size

    class ViewHolder(val binding: ItemLigneBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.id
        val joueursView: TextView = binding.joueurs
        val scoreView: TextView = binding.score
    }

    fun scoreToString(score:List<Int>): String {
        var score_string = ""
        for (number in score) {
            score_string+=number
            score_string+=" "
        }
        return score_string
    }
}
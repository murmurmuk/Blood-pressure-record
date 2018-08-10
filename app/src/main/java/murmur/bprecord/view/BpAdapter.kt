package murmur.bprecord.view

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import murmur.bprecord.R
import murmur.bprecord.databinding.ItemViewBinding
import murmur.bprecord.model.db.entity.BpEntity
import murmur.bprecord.util.BpEntityUtil

class BpAdapter(private val list: List<BpEntity>) : RecyclerView.Adapter<BpViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BpViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemViewBinding>(layoutInflater,
                R.layout.item_view, parent, false)
        return BpViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(p0: BpViewHolder, p1: Int) {
        p0.bind(list[p1])
    }

}

class BpViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: BpEntity) {
        binding.data = item
        binding.util = BpEntityUtil
        binding.executePendingBindings()
    }
}
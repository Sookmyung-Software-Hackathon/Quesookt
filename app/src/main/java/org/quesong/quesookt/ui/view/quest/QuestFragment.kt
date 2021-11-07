package org.quesong.quesookt.ui.view.quest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.quesong.core.base.BindingFragment
import org.quesong.quesookt.R
import org.quesong.quesookt.data.local.QuesooktPreference
import org.quesong.quesookt.databinding.FragmentQuestBinding
import org.quesong.quesookt.ui.view.quest.adapter.QuestAdapter
import org.quesong.quesookt.ui.view.quest.model.QuestInfoData
import org.quesong.quesookt.ui.view.quest.model.ResponseQuestData
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.JINRI
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.PRIME
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.RENAISSANCE
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.SUNHEON

class QuestFragment : BindingFragment<FragmentQuestBinding>(R.layout.fragment_quest) {
    private lateinit var questAdapter: QuestAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initQuestAdapter()
    }

    private fun initQuestAdapter() {
        questAdapter = QuestAdapter()
        binding.rvQuest.adapter = questAdapter

        getQuestData()
        initQuestClickListener()
    }

    private fun getQuestData() {
        var domitory: String = ""
        domitory = when(QuesooktPreference.getDormitory()) {
            JINRI -> "jinri"
            SUNHEON -> "soonheon"
            PRIME -> "prime"
            RENAISSANCE -> "rnesang"
            else -> ""
        }
        val listData: MutableList<ResponseQuestData> = mutableListOf<ResponseQuestData>()
        val questList: MutableList<ResponseQuestData> = mutableListOf()
        val database = FirebaseDatabase.getInstance()
        val indexList = mutableListOf<Int>()
        database.getReference("Grp").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (userSnapshot in dataSnapshot.child(domitory).children){
                    val getData: Int? = userSnapshot.getValue(Int::class.java)
                    indexList.add(getData!!)
                    //Log.d("wow", listData.toString())
                }
                for(userSnapshot in dataSnapshot.child("QuestData").children){
                    val getData: ResponseQuestData? = userSnapshot.getValue(ResponseQuestData::class.java)
                    listData.add(getData!!)
                }
                for(idx in indexList) {
                    questList.add(listData[idx])
                }
                questAdapter.questList = questList
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("what", "help me"); // 에러문 출력
            }
        })
    }

    private fun initQuestClickListener() {
        questAdapter.setQuestClickListener {
            val intent = Intent(requireContext(), QuestDetailActivity::class.java)
            with(it) {
                intent.apply {
                    putExtra("title", title)
                    putExtra("imgUrl", imgUrl)
                    putExtra("state", state)
                    putExtra("description", description)
                    putExtra("tip", tip)
                    putExtra("isStarted", isStarted)
                }
            }
            startActivity(intent)
        }
    }
}
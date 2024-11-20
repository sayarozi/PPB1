package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FriendsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FriendsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var friendAdapter: MyFriendAdapter
    private val friends = mutableListOf<MyFriend>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_friends, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView(){
        friends.addAll(
            listOf(
                MyFriend("Andi Saputra", "081234567890", "andisaputra@gmail.com"),
                MyFriend("Siti Nurhaliza", "082345678901", "sitinurhaliza@yahoo.com"),
                MyFriend("Ahmad Dani", "083456789012", "ahmaddani@gmail.com"),
                MyFriend("Rina Novitasari", "084567890123", "rinanovitasari@outlook.com"),
                MyFriend("Budi Santoso", "085678901234", "budisantoso@gmail.com"),
                MyFriend("Wati Sulastri", "086789012345", "watisulastri@yahoo.com"),
                MyFriend("Dedi Setiawan", "087890123456", "dedisetiawan@gmail.com"),
                MyFriend("Sri Wahyuni", "088901234567", "sriwahyuni@outlook.com"),
                MyFriend("Bambang Susanto", "089012345678", "bambangsusanto@gmail.com"),
                MyFriend("Citra Paramita", "080123456789", "citraparamita@yahoo.com"),
                MyFriend("Agus Prasetyo", "081234567890", "agusprasetyo@gmail.com"),
                MyFriend("Sri Rejeki", "082345678901", "srirejeki@yahoo.com"),
                MyFriend("Joko Susilo", "083456789012", "jokosusilo@gmail.com"),
                MyFriend("Ani Lestari", "084567890123", "anilestari@outlook.com"),
                MyFriend("Supriyadi", "085678901234", "supriyadi@gmail.com"),
                MyFriend("Endang Setyawati", "086789012345", "endangsetyawati@yahoo.com"),
                MyFriend("Heru Susanto", "087890123456", "herususanto@gmail.com"),
                MyFriend("Tuti Hartati", "088901234567", "tutihartati@outlook.com"),
                MyFriend("Edi Susanto", "089012345678", "edisusanto@gmail.com"),
                MyFriend("Wulan Sari", "080123456789", "wulansari@yahoo.com")
            )
        )
        friendAdapter = MyFriendAdapter(friends)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = friendAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FriendsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FriendsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
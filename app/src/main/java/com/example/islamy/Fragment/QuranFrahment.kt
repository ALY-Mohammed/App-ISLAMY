import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.Fragment.Adapters.quranAdapter
import com.example.islamy.QuranDetailsActivity
import com.example.islamy.R


class QuranFrahment: Fragment(){

    lateinit var quranrecyclerView: RecyclerView
    lateinit var suraadapter: quranAdapter
     val suranames= listOf<String>("الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
         ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
         ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
         ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
         ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
         ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
         ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
         ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
         ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
         "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranrecyclerView = view.findViewById(R.id.suraNameRecyclerView)
        suraadapter = quranAdapter(suranames)
        suraadapter.setOnTextClicked = object : quranAdapter.setOnclickListenerSuraName {
            override fun suraNameTextclicked(itemsV: String, position: Int) {
                val intent = Intent(requireContext(),QuranDetailsActivity::class.java)
                intent.putExtra("name",itemsV)
                intent.putExtra("sura","${position+1}.txt") //send file Name to open it there
                startActivity(intent)


            }

        }
       quranrecyclerView.adapter = suraadapter

    }

    }



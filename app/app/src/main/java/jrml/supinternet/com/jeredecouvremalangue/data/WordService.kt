package jrml.supinternet.com.jeredecouvremalangue.data

import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word
import java.util.*
import kotlin.collections.ArrayList

class WordService{
    companion object {
        var datas: HashMap<Int, Word>
        init {
            val descList: ArrayList<String> = arrayListOf("Pardonnez-moi le style désultoire de ma lettre. — (Charles-Augustin Sainte-Beuve, Portraits littéraires, tome 3)",
                    "Ce seront les mêmes promenades dans le parc, les mêmes conversations désultoires avec les fermiers. — (Marguerite Yourcenar, Quoi ? L’Éternité, Gallimard, 1988, page 78)",
                    "Pardonnez-moi le style désultoire de ma lettre. — (Charles-Augustin Sainte-Beuve, Portraits littéraires, tome 3)")
            val word = Word("désultoire", "Du latin desultorius," +
                    " cheval qui sert à la voltige, de desultor, celui qui passe d’un objet à un autre, " +
                    "proprement cavalier qui saute à bas de son cheval", descList)
            val descList1: ArrayList<String> = arrayListOf("Pour les âmes timorées de ces habitudinaires qui n'osent plus, après de persévérantes chutes, franchir le seuil de l'église [...] (J.-K. Huysmans, La Cathédrale, 1898)")
            val word1 = Word("Habitudinaire", "Théol., celui qui commet les mêmes péchés"
                    , descList1)
            val descList2: ArrayList<String> = arrayListOf("Antoine effrayé se bouche les oreilles, pousse un cri, et la foule des hérésies s'entr'ouvre pour donner passage au chœur des ophites, portant un immense serpent-python à couleur dorée, avec des taches de saphir et des taches noires (G. Flaubert, La Tentation de saint Antoine, 1849)")
            val word2 = Word("Ophite", "Membre d'une secte gnostique du IIème siècle qui vouait un culte au serpent et voyait en cet animal un symbole du messie"
                    , descList2)
            val descList3: ArrayList<String> = arrayListOf("Antant vaudrait être la femme de quelque pauvre paraschiste inciseur de cadavres et faire fondre du natron dans une chaudière! (Th. Gautier, Une nuit de Cléopâtre, 1838)")
            val word3 = Word("Paraschiste", "Embaumeur de cadavre spécialisé dans l'extraction des vicères"
                    , descList3)
            datas = linkedMapOf(1 to word, 2 to word1, 3 to word2, 4 to word3)
            //create the datas
        }

        fun getWords():  HashMap<Int, Word>{
            return datas
        }

        fun getWord(id: Int): Word?{
            return datas[id]
        }

        fun getRandomWordId() :Int{
            val keysAsArray = ArrayList(datas.keys)
            val r = Random()
            return keysAsArray.get(r.nextInt(keysAsArray.size))
        }
    }
}

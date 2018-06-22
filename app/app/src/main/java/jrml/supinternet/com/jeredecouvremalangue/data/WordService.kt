package jrml.supinternet.com.jeredecouvremalangue.data

import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word

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
            val descList1: ArrayList<String> = arrayListOf("Pour les âmes timorées de ces habitudinaires qui n'osent plus, après de persévérantes chutes, franchir le seuil de l'église [...] (J.-K. Huysmans, La Cathédrale, 1898")
            val word1 = Word("Habitudinaire", "Théol., celui qui commet les mêmes péchés"
                    , descList1)
            datas = hashMapOf(1 to word, 2 to word1)
            //create the datas
        }

        fun getWords():  HashMap<Int, Word>{
            return datas
        }

        fun getWord(id: Int): Word?{
            return datas[id]
        }
    }
}

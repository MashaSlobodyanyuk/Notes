    fun main(){
       var n1 = Note(1,"m","n",0,0,0,0)

        println(n1)

        n1.createComment("nana")
        println(n1)

        n1.createComment("lala")
        println(n1)

        n1.createComment("popa")
        println(n1)

        println("______________________________")

        var n2 = Note(32,"ma","na",1,1,1,1)
        println(n2)

       println( n1.getCommentss())
        println( n2.getCommentss())

        println("______________________________")
        n1.deleteComment(2)
        println(n1)
        n1.restoreComment(2)
        println(n1)






    }
import org.junit.Test

import org.junit.Assert.*

class NoteTest {

    @Test
    fun createComment() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        n1.createComment("m")
        val result = n1.comments.count()
        assertEquals(result, 1)
    }

    @Test(expected = RuntimeException::class)
    fun deleteCommentError() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        n1.deleteComment(2)

    }

    @Test
    fun deleteComment() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        n1.createComment("m")
        val result = n1.deleteComment(1)
        assertEquals(result, 1)
    }

    @Test(expected = RuntimeException::class)
    fun editCommentError() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        n1.createComment("m")
        n1.editComment(2, "haha")
    }

    fun editComment() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        n1.createComment("mad")
        var result = n1.editComment(1, "haha")
        assertEquals(result, 1)

    }

    @Test
    fun getCommentssEmpty() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        val result = n1.getCommentss()
        val comments: MutableList<Comment> = mutableListOf()
        assertEquals(result, comments)


    }

    @Test
    fun getCommentssWithComment() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        n1.createComment("mad")
        n1.getCommentss()
        var result = n1.comments.last().messege
        assertEquals(result, "mad")
        assertEquals(n1.comments.last().id, 1)
    }

    @Test(expected = RuntimeException::class)
    fun restoreCommentEror() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        n1.restoreComment(15)

    }

    @Test
    fun restoreCommentCorrect() {
        var n1 = Note(1, "m", "n", 0, 0, 0, 0)
        n1.createComment("mad")
        val result1 = n1.comments.last().messege
        assertEquals(result1, "mad")

        n1.deleteComment(1)
        n1.restoreComment(1)
        val result2 = n1.comments.last().messege
        assertEquals(result2, "mad")
    }
}



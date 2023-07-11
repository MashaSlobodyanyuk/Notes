data class Note(
    val id: Int,
    val title: String,
    val text: String,
    val privacy: Int,
    val commentPrivacy: Int,
    val privacyView: Int,
    val privacyComment: Int,
    val comments: MutableList<Comment> = mutableListOf()
) {

    private var commentId = 0
    private var deleteComments = mutableListOf<Comment>()

    //Добавляет новый комментарий к заметке
    fun createComment(messege: String): Int {

        commentId++
        comments.add(Comment(commentId, messege))
        return commentId
    }


    //Удаляет комментарий к заметке
    fun deleteComment(commentId: Int): Int {
        for (comment in comments) {
            if (commentId == comment.id) {
                comments.remove(comment)
                deleteComments.add(comment)

                return 1
            }
        }
        throw RuntimeException("Ошибка в удалении комментария")
    }

    //Редактирует указанный комментарий у заметки
    fun editComment(commentId: Int, message: String): Int {
        for (comment in comments) {
            if (commentId == comment.id) {
                var newComment = comment.copy(messege = message)
                comments.remove(comment)
                comments.add(newComment)
                return 1
            }

        }
        throw RuntimeException("Ошибка в редактировании комментария")
    }


    //Возвращает список комментариев к заметке
    fun getCommentss(): MutableList<Comment> {
        return comments
    }

    //Восстанавливает удалённый комментарий
    fun restoreComment(id: Int) {
        for (comment in deleteComments) {
            if (comment.id == id) {
                deleteComments.remove(comment)
                comments.add(comment)
                return
            }
        }
        throw RuntimeException("Ошибка в восстановлении элемента")
    }


}
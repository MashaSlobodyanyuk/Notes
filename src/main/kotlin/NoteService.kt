object NoteService {
    private var noteId = 0

    var notes: MutableList<Note> = mutableListOf()

    fun add(
        title: String,
        text: String,
        privacy: Int,
        commentPrivacy: Int,
        privacyView: Int,
        privacyComment: Int
    ): Int {
        noteId += 1
        notes.add(Note(noteId, title, text, privacy, commentPrivacy, privacyView, privacyComment))
        return noteId
    }


    fun clear() {
        noteId = 0
        notes = mutableListOf()

        // также здесь нужно сбросить счетчик для id постов, если он у вас используется
    }

    fun delete(noteId: Int): Int {

        for (note in notes) {
            if (note.id == noteId) {
                notes.remove(note)
                return 1
            }
        }

        throw RuntimeException("Ошибка в удалении заметки")

    }

    //Редактирует заметку текущего пользователя
    fun edit(
        noteId: Int,
        title: String,
        text: String,
        privacy: Int,
        commentPrivacy: Int,
        privacyView: Int,
        privacyComment: Int
    ): Int {
        for (note in notes) {
            if (note.id == noteId) {
                var newNote = note.copy(title = title, text = text)
                notes.remove(note)
                notes.add(newNote)
                return 1
            }

        }
        throw RuntimeException("Ошибка в редактировании заметки")
    }


    //Возвращает список заметок, созданных пользователем
    fun get(noteIds: Array<Int>): MutableList<Note> {
        var result: MutableList<Note> = mutableListOf()

        for (note in notes) {
            if (noteIds.contains(note.id)) {
                result.add(note)
            }
        }
        return result
    }

    //Возвращает заметку по её id
    fun getById(noteId: Int): Note? {
        for (note in notes) {
            if (noteId == note.id)
                return note
        }
        return null

    }
}
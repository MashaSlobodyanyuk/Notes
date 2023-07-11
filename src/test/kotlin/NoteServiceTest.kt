import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NoteServiceTest {

    @Before
    fun clearBeforeTest() {
        NoteService.clear()
    }

    @Test
    fun add() {
        val result = NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)
        assertEquals(result, 1)
    }


    @Test(expected = RuntimeException::class)
    fun deleteError() {
        NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)
        val result = NoteService.delete(5)
    }

    @Test
    fun delete() {
        NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)
        val result = NoteService.delete(1)
        assertEquals(result, 1)
    }

    @Test(expected = RuntimeException::class)
    fun editError() {
        NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)
        var result = NoteService.edit(0, "Bla", "vino", 0, 0, 0, 0)

    }

    @Test
    fun edit() {
        NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)
        var result = NoteService.edit(1, "Bla", "vino", 1, 1, 1, 1)
        assertEquals(result, 1)
    }

    @Test
    fun getEmpty() {

        var notes = NoteService.get(arrayOf(1, 2, 3))
        assertEquals(notes.isEmpty(), true)
    }

    @Test
    fun get() {

        NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)
        NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)
        NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)

        var notes = NoteService.get(arrayOf(1, 2, 3))

        assertEquals(notes.count(), 3)
    }

    @Test
    fun getByIdEmpty() {
        var notes = NoteService.getById(1)
        assertEquals(notes, null)
    }

    @Test
    fun getById() {
        NoteService.add("ghj", "jhgjhhj", 1, 1, 1, 1)
        var note = NoteService.getById(1)
        assertEquals(note?.title, "ghj")

    }

}
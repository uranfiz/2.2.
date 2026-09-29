import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class WallServiceTest {

    @Test
    fun addAssignsNonZeroId() {
        val service = WallService()
        val post = Post(text = "Hello")

        val result = service.add(post)

        assertNotEquals(0, result.id)
    }

    @Test
    fun updateExistingReturnsTrue() {
        val service = WallService()
        service.add(Post(text = "First"))
        val added = service.add(Post(text = "Second"))
        service.add(Post(text = "Third"))

        val update = added.copy(text = "Updated text")
        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateNonExistingReturnsFalse() {
        val service = WallService()
        service.add(Post(text = "First"))
        service.add(Post(text = "Second"))

        val update = Post(id = 999, text = "Doesn't exist")
        val result = service.update(update)

        assertFalse(result)
    }
}

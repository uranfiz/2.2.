package ru.netology

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WallServiceTest {

    @Test
    fun addShouldAssignId() {
        val service = WallService()
        val post = Post(text = "Новый пост")
        val result = service.add(post)
        assertNotEquals(0, result.id)
    }

    @Test
    fun updateExistingPostReturnsTrue() {
        val service = WallService()
        service.add(Post(text = "Старый текст"))
        val update = Post(id = 1, text = "Новый текст")
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNonExistingPostReturnsFalse() {
        val service = WallService()
        service.add(Post(text = "Старый текст"))
        val update = Post(id = 99, text = "Новый текст")
        val result = service.update(update)
        assertFalse(result)
    }
}

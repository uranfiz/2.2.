class WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        for ((index, existing) in posts.withIndex()) {
            if (existing.id == post.id) {
                posts[index] = post.copy(id = existing.id)
                return true
            }
        }
        return false
    }
}

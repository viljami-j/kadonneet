package com.ihmistenit.kadonneet.placeholder

import android.graphics.Bitmap
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<UserAdvertItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, UserAdvertItem> = HashMap()

    val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createUserAdvertItem(i))
        }
    }

    private fun addItem(item: UserAdvertItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createUserAdvertItem(position: Int): UserAdvertItem {
        return UserAdvertItem(position.toString(), "Item " + position, null)
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class UserAdvertItem(val id: String, val content: String, val image: Bitmap?) {
        override fun toString(): String = content
    }
}
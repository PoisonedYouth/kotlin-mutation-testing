package com.poisonedyouth

object ApplicationService {

    fun filterList(list: List<String>, filter: String): List<String> {
        if (filter.isBlank()) {
            return list
        }
        val result = mutableListOf<String>()
        for(element in list) {
            if (element.startsWith(filter)) {
                result.add(element)
            }
        }
        return result.toList()
    }
}

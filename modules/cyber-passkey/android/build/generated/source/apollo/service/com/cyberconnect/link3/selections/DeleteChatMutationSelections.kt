//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.DeleteChatResponse
import com.cyberconnect.link3.type.DeleteChatResponse_Status
import kotlin.collections.List

public object DeleteChatMutationSelections {
  private val __deleteChat: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = DeleteChatResponse_Status.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "deleteChat",
          type = DeleteChatResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("chatId", CompiledVariable("chatId")).build()
        ))
        .selections(__deleteChat)
        .build()
      )
}

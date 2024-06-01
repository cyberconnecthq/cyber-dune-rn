//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.fragment.selections.PriceSelections
import com.cyberconnect.link3.type.Chat
import com.cyberconnect.link3.type.ChatPrice
import com.cyberconnect.link3.type.ChatPriceStatus
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.MeResponse
import com.cyberconnect.link3.type.TokenValue
import com.cyberconnect.link3.type.User
import kotlin.collections.List

public object MessagePriceQuerySelections {
  private val __price1: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "TokenValue",
          possibleTypes = listOf("TokenValue")
        ).selections(PriceSelections.__root)
        .build()
      )

  private val __price: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "price",
          type = TokenValue.type.notNull()
        ).selections(__price1)
        .build(),
        CompiledField.Builder(
          name = "priceStatus",
          type = ChatPriceStatus.type.notNull()
        ).build()
      )

  private val __chat: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "price",
          type = ChatPrice.type.notNull()
        ).selections(__price)
        .build()
      )

  private val __data: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "chat",
          type = Chat.type
        ).arguments(listOf(
          CompiledArgument.Builder("id", CompiledVariable("id")).build()
        ))
        .selections(__chat)
        .build()
      )

  private val __me: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "data",
          type = User.type
        ).selections(__data)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "me",
          type = MeResponse.type.notNull()
        ).selections(__me)
        .build()
      )
}
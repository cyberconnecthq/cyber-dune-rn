//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.MeResponse
import com.cyberconnect.link3.type.User
import kotlin.collections.List

public object UnreadNotificationCountQuerySelections {
  private val __data: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "unreadNotificationsCount",
          type = GraphQLInt.type
        ).build()
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

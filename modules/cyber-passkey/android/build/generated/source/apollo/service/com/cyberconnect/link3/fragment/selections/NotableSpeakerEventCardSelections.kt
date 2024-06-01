//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.EventRegisterStatus
import com.cyberconnect.link3.type.EventStatus
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.Timestamp
import kotlin.collections.List

public object NotableSpeakerEventCardSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "title",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "startTimestamp",
          type = Timestamp.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "endTimestamp",
          type = Timestamp.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "registerStatus",
          type = EventRegisterStatus.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "registrantsCount",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "status",
          type = EventStatus.type.notNull()
        ).build()
      )
}

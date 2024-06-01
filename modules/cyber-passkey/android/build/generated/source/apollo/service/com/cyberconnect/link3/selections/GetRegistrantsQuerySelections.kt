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
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.fragment.selections.PageInfoSelections
import com.cyberconnect.link3.type.Event
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.LightInfo
import com.cyberconnect.link3.type.PageInfo
import com.cyberconnect.link3.type.User
import com.cyberconnect.link3.type.UserPage
import kotlin.collections.List

public object GetRegistrantsQuerySelections {
  private val __pageInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "PageInfo",
          possibleTypes = listOf("PageInfo")
        ).selections(PageInfoSelections.__root)
        .build()
      )

  private val __lightInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "avatar",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "formattedAddress",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "avatarFrameTokenId",
          type = GraphQLID.type
        ).build(),
        CompiledField.Builder(
          name = "handle",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __list: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "lightInfo",
          type = LightInfo.type.notNull()
        ).selections(__lightInfo)
        .build()
      )

  private val __registrants: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "pageInfo",
          type = PageInfo.type.notNull()
        ).selections(__pageInfo)
        .build(),
        CompiledField.Builder(
          name = "list",
          type = User.type.notNull().list().notNull()
        ).selections(__list)
        .build()
      )

  private val __event: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "registrantsCount",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "registrants",
          type = UserPage.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("after", CompiledVariable("after")).build(),
          CompiledArgument.Builder("first", CompiledVariable("first")).build()
        ))
        .selections(__registrants)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "event",
          type = Event.type
        ).arguments(listOf(
          CompiledArgument.Builder("id", CompiledVariable("id")).build()
        ))
        .selections(__event)
        .build()
      )
}
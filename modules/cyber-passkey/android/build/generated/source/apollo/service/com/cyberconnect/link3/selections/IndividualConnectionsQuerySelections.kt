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
import com.cyberconnect.link3.fragment.selections.ConnectionPersonalProfileSelections
import com.cyberconnect.link3.fragment.selections.PageInfoSelections
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.MeResponse
import com.cyberconnect.link3.type.PageInfo
import com.cyberconnect.link3.type.Profile
import com.cyberconnect.link3.type.ProfilePage
import com.cyberconnect.link3.type.User
import kotlin.collections.List

public object IndividualConnectionsQuerySelections {
  private val __list: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "PerProfile",
          possibleTypes = listOf("PerProfile")
        ).selections(ConnectionPersonalProfileSelections.__root)
        .build()
      )

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

  private val __recommendedProfiles: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "list",
          type = Profile.type.notNull().list().notNull()
        ).selections(__list)
        .build(),
        CompiledField.Builder(
          name = "pageInfo",
          type = PageInfo.type.notNull()
        ).selections(__pageInfo)
        .build()
      )

  private val __data: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "recommendedProfiles",
          type = ProfilePage.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("after", CompiledVariable("after")).build(),
          CompiledArgument.Builder("first", 12).build()
        ))
        .selections(__recommendedProfiles)
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
        ).alias("recommended")
        .selections(__me)
        .build()
      )
}

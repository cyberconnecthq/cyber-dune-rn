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
import com.cyberconnect.link3.type.PageInfo
import com.cyberconnect.link3.type.Profile
import com.cyberconnect.link3.type.ProfilePage
import kotlin.collections.List

public object RecentVerifiedProfilesQuerySelections {
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

  private val __recentVerifiedProfiles: List<CompiledSelection> = listOf(
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

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "recentVerifiedProfiles",
          type = ProfilePage.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("after", CompiledVariable("after")).build(),
          CompiledArgument.Builder("first", 20).build()
        ))
        .selections(__recentVerifiedProfiles)
        .build()
      )
}
//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.ProfileType
import kotlin.collections.List

public object UnionBaseProfileSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "type",
          type = ProfileType.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "handle",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "Profile",
          possibleTypes = listOf("OrgProfile", "PerProfile")
        ).selections(UnionIsFollowingSelections.__root)
        .build(),
        CompiledFragment.Builder(
          typeCondition = "Profile",
          possibleTypes = listOf("OrgProfile", "PerProfile")
        ).selections(UnionDisplayNameSelections.__root)
        .build(),
        CompiledFragment.Builder(
          typeCondition = "Profile",
          possibleTypes = listOf("OrgProfile", "PerProfile")
        ).selections(UnionProfilePictureSelections.__root)
        .build()
      )
}
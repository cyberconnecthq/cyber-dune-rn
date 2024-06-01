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
import com.cyberconnect.link3.type.PersonalDisplayName
import kotlin.collections.List

public object UnionDisplayNameSelections {
  private val __onOrgProfile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __displayName1: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __onPerProfile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "displayName",
          type = PersonalDisplayName.type.notNull()
        ).alias("personalDisplayName")
        .selections(__displayName1)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "OrgProfile",
          possibleTypes = listOf("OrgProfile")
        ).selections(__onOrgProfile)
        .build(),
        CompiledFragment.Builder(
          typeCondition = "PerProfile",
          possibleTypes = listOf("PerProfile")
        ).selections(__onPerProfile)
        .build()
      )
}

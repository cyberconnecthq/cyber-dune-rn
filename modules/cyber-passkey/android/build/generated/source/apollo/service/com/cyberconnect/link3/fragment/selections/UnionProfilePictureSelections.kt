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
import com.cyberconnect.link3.type.PersonalPicture
import kotlin.collections.List

public object UnionProfilePictureSelections {
  private val __onOrgProfile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "profilePicture",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __profilePicture1: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "picture",
          type = GraphQLString.type
        ).build()
      )

  private val __onPerProfile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "profilePicture",
          type = PersonalPicture.type.notNull()
        ).alias("personalProfilePicture")
        .selections(__profilePicture1)
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
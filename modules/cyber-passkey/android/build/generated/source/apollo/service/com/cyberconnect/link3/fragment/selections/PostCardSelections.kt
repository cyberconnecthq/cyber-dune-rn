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
import com.cyberconnect.link3.type.DateTime
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.PostEssence
import com.cyberconnect.link3.type.Profile
import com.cyberconnect.link3.type.Url
import kotlin.collections.List

public object PostCardSelections {
  private val __essence: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "totalCollected",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "totalSupply",
          type = GraphQLInt.type.notNull()
        ).build()
      )

  private val __profile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "Profile",
          possibleTypes = listOf("OrgProfile", "PerProfile")
        ).selections(ProfileInPostCardSelections.__root)
        .build()
      )

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
          name = "cover",
          type = Url.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "description",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "publishedAt",
          type = DateTime.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "readTime",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "essence",
          type = PostEssence.type
        ).selections(__essence)
        .build(),
        CompiledField.Builder(
          name = "profile",
          type = Profile.type.notNull()
        ).selections(__profile)
        .build()
      )
}
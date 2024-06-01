//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.ConnectStatus
import com.cyberconnect.link3.type.GraphQLBoolean
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.HeadlineType
import com.cyberconnect.link3.type.PersonalPicture
import com.cyberconnect.link3.type.Profile
import com.cyberconnect.link3.type.ProfilePage
import com.cyberconnect.link3.type.ReputationScore
import com.cyberconnect.link3.type.Twitter
import com.cyberconnect.link3.type.Url
import kotlin.collections.List

public object TargetUserProfileSelections {
  private val __reputation: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "total",
          type = GraphQLInt.type.notNull()
        ).build()
      )

  private val __profilePicture: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "picture",
          type = GraphQLString.type
        ).build()
      )

  private val __onPerProfile: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "profilePicture",
          type = PersonalPicture.type.notNull()
        ).selections(__profilePicture)
        .build()
      )

  private val __list: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "PerProfile",
          possibleTypes = listOf("PerProfile")
        ).selections(__onPerProfile)
        .build()
      )

  private val __mutualConnections: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "list",
          type = Profile.type.notNull().list().notNull()
        ).selections(__list)
        .build()
      )

  private val __headline: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "twitterId",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "twitterHandle",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "avatar",
          type = Url.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "title",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "description",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "profileId",
          type = GraphQLID.type
        ).build(),
        CompiledField.Builder(
          name = "headlineType",
          type = HeadlineType.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "connectStatus",
          type = ConnectStatus.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "reputation",
          type = ReputationScore.type.notNull()
        ).selections(__reputation)
        .build(),
        CompiledField.Builder(
          name = "mutualConnectionCount",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "mutualConnections",
          type = ProfilePage.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("after", "").build(),
          CompiledArgument.Builder("first", 3).build()
        ))
        .selections(__mutualConnections)
        .build(),
        CompiledField.Builder(
          name = "isVerified",
          type = GraphQLBoolean.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "headline",
          type = Twitter.type.notNull()
        ).selections(__headline)
        .build()
      )
}

//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.DiscordUser
import com.cyberconnect.link3.type.EventAudience
import com.cyberconnect.link3.type.GraphQLBoolean
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.PageInfo
import com.cyberconnect.link3.type.TwitterUser
import com.cyberconnect.link3.type.UserAnalysisInfo
import kotlin.collections.List

public object EventAudiencePageSelections {
  private val __pageInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "startCursor",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "endCursor",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "hasNextPage",
          type = GraphQLBoolean.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "hasPreviousPage",
          type = GraphQLBoolean.type.notNull()
        ).build()
      )

  private val __discord: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "discordId",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "discriminator",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "avatar",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "role",
          type = GraphQLString.type.notNull().list().notNull()
        ).build()
      )

  private val __twitter: List<CompiledSelection> = listOf(
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
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "followersCount",
          type = GraphQLInt.type.notNull()
        ).build()
      )

  private val __user: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "address",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "profileId",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "avatar",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "displayName",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "avatarFrameTokenId",
          type = GraphQLID.type
        ).build(),
        CompiledField.Builder(
          name = "isKol",
          type = GraphQLBoolean.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "discord",
          type = DiscordUser.type
        ).selections(__discord)
        .build(),
        CompiledField.Builder(
          name = "twitter",
          type = TwitterUser.type
        ).selections(__twitter)
        .build()
      )

  private val __list: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "stayTime",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "raffleClaimed",
          type = GraphQLBoolean.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "user",
          type = UserAnalysisInfo.type.notNull()
        ).selections(__user)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "pageInfo",
          type = PageInfo.type.notNull()
        ).selections(__pageInfo)
        .build(),
        CompiledField.Builder(
          name = "list",
          type = EventAudience.type.notNull().list().notNull()
        ).selections(__list)
        .build()
      )
}

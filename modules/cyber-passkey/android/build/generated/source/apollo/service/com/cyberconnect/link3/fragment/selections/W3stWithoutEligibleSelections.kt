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
import com.cyberconnect.link3.type.EVMAddress
import com.cyberconnect.link3.type.GraphQLBoolean
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.Url
import com.cyberconnect.link3.type.W3STContractInfo
import com.cyberconnect.link3.type.W3STDeployStatus
import com.cyberconnect.link3.type.W3STRequirement
import com.cyberconnect.link3.type.W3STRequirementType
import kotlin.collections.List

public object W3stWithoutEligibleSelections {
  private val __contractInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "deployStatus",
          type = W3STDeployStatus.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "profileAddress",
          type = EVMAddress.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "chainId",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "essenceAddress",
          type = EVMAddress.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "essenceId",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "tokenHoldersCount",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "profileId",
          type = GraphQLInt.type.notNull()
        ).build()
      )

  private val __requirements: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "type",
          type = W3STRequirementType.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "value",
          type = GraphQLInt.type
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "gasless",
          type = GraphQLBoolean.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "imageUrl",
          type = Url.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "contractInfo",
          type = W3STContractInfo.type.notNull().list()
        ).selections(__contractInfo)
        .build(),
        CompiledField.Builder(
          name = "requirements",
          type = W3STRequirement.type.notNull().list().notNull()
        ).selections(__requirements)
        .build()
      )
}

//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.CreateSkillMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.CreateSkillMutation_VariablesAdapter
import com.cyberconnect.link3.selections.CreateSkillMutationSelections
import com.cyberconnect.link3.type.CreateSkillInput
import com.cyberconnect.link3.type.CreateSkillResponse_Status
import kotlin.String
import kotlin.Unit

public data class CreateSkillMutation(
  public val input: CreateSkillInput,
) : Mutation<CreateSkillMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    CreateSkillMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = CreateSkillMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = CreateSkillMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(CreateSkillMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val createSkill: CreateSkill,
  ) : Mutation.Data

  public data class CreateSkill(
    public val status: CreateSkillResponse_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "e61c1d8c6b3c3da1d4b2a5d1b0947dc88cea848b5126ba7c74dd964fbb5bfc5b"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation createSkill($input: CreateSkillInput!) {
     *   createSkill(input: $input) {
     *     status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation createSkill(${'$'}input: CreateSkillInput!) { createSkill(input: ${'$'}input) { status } }"

    public const val OPERATION_NAME: String = "createSkill"
  }
}

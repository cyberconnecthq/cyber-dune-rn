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
import com.cyberconnect.link3.adapter.LikeMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.LikeMutation_VariablesAdapter
import com.cyberconnect.link3.selections.LikeMutationSelections
import com.cyberconnect.link3.type.LikePostRequest
import com.cyberconnect.link3.type.LikePostResponse_Status
import kotlin.String
import kotlin.Unit

public data class LikeMutation(
  public val input: LikePostRequest,
) : Mutation<LikeMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    LikeMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = LikeMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = LikeMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(LikeMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val like: Like,
  ) : Mutation.Data

  public data class Like(
    public val status: LikePostResponse_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "933e721e1f67126e263bda74b06f0ed69b0a9e89c0a426f117e5cb3856472e6b"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation like($input: LikePostRequest!) {
     *   like(input: $input) {
     *     status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() = "mutation like(${'$'}input: LikePostRequest!) { like(input: ${'$'}input) { status } }"

    public const val OPERATION_NAME: String = "like"
  }
}

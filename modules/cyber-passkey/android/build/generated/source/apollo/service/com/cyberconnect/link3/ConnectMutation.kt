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
import com.cyberconnect.link3.adapter.ConnectMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.ConnectMutation_VariablesAdapter
import com.cyberconnect.link3.selections.ConnectMutationSelections
import com.cyberconnect.link3.type.ConnectResponse_Status
import kotlin.String
import kotlin.Unit

public data class ConnectMutation(
  public val profileId: String,
) : Mutation<ConnectMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    ConnectMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = ConnectMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = ConnectMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(ConnectMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val connect: Connect,
  ) : Mutation.Data

  public data class Connect(
    public val status: ConnectResponse_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "9ea8c70b92ba60fa450b64a7c93101d0c2bb811847ca7dbd87d3ab4f091c3a40"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation connect($profileId: String!) {
     *   connect(input: {
     *     profileId: $profileId
     *   }
     *   ) {
     *     status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation connect(${'$'}profileId: String!) { connect(input: { profileId: ${'$'}profileId } ) { status } }"

    public const val OPERATION_NAME: String = "connect"
  }
}
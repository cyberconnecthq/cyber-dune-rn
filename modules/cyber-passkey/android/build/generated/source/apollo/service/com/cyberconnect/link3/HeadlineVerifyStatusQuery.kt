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
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.HeadlineVerifyStatusQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.HeadlineVerifyStatusQuery_VariablesAdapter
import com.cyberconnect.link3.selections.HeadlineVerifyStatusQuerySelections
import com.cyberconnect.link3.type.EasWhitelistVerifyStatusResponse_Status
import com.cyberconnect.link3.type.HeadlineType
import kotlin.String
import kotlin.Unit

public data class HeadlineVerifyStatusQuery(
  public val orgTwitterId: String,
  public val headlineType: HeadlineType,
) : Query<HeadlineVerifyStatusQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    HeadlineVerifyStatusQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> =
      HeadlineVerifyStatusQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = HeadlineVerifyStatusQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(HeadlineVerifyStatusQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val easWhitelistVerifyStatus: EasWhitelistVerifyStatus,
  ) : Query.Data

  public data class EasWhitelistVerifyStatus(
    public val status: EasWhitelistVerifyStatusResponse_Status,
    public val verifyStatus: com.cyberconnect.link3.type.EasWhitelistVerifyStatus,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "d8724a0780b42d31a05adf02eb92d761f7fd6e55428004659a7d1499afd1ed97"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query headlineVerifyStatus($orgTwitterId: String!, $headlineType: HeadlineType!) {
     *   easWhitelistVerifyStatus(twitterId: $orgTwitterId, headlineType: $headlineType) {
     *     status
     *     verifyStatus
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query headlineVerifyStatus(${'$'}orgTwitterId: String!, ${'$'}headlineType: HeadlineType!) { easWhitelistVerifyStatus(twitterId: ${'$'}orgTwitterId, headlineType: ${'$'}headlineType) { status verifyStatus } }"

    public const val OPERATION_NAME: String = "headlineVerifyStatus"
  }
}
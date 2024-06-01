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
import com.cyberconnect.link3.adapter.ClaimEasMutation_ResponseAdapter
import com.cyberconnect.link3.selections.ClaimEasMutationSelections
import com.cyberconnect.link3.type.ClaimEasAttestationResponse_Status
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public class ClaimEasMutation() : Mutation<ClaimEasMutation.Data> {
  public override fun equals(other: Any?): Boolean = other != null && other::class == this::class

  public override fun hashCode(): Int = this::class.hashCode()

  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    // This operation doesn't have any variable
  }

  public override fun adapter(): Adapter<Data> = ClaimEasMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = ClaimEasMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(ClaimEasMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val ClaimEasAttestation: ClaimEasAttestation,
  ) : Mutation.Data

  public data class ClaimEasAttestation(
    public val Status: ClaimEasAttestationResponse_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "65a2b3e47631507b105654acbc9fcb6789d0e6b2934c9d2996c3066fc4ce1090"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation claimEas {
     *   ClaimEasAttestation {
     *     Status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() = "mutation claimEas { ClaimEasAttestation { Status } }"

    public const val OPERATION_NAME: String = "claimEas"
  }
}
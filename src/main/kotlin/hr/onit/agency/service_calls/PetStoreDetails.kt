package hr.onit.agency.service_calls

import hr.onit.agency.agent.Agent
import hr.onit.agency.agent.SessionKeys
import hr.onit.agency.client.api.PetApi
import org.openapitools.client.infrastructure.ApiClient
import kotlin.reflect.KClass

class PetStoreDetails : ServiceCall() {
    val petApi = PetApi(basePath())

    override fun execute(agent:Agent) {
        petApi.getPetById(agent.session.get(SessionKeys.PET_ID) as Long)
    }

    override fun requiredSessionValues(): List<SessionKeys> {
        return mutableListOf(SessionKeys.PET_ID)
    }

    override fun nextPossibleCalls(): List<KClass<out ServiceCall>> {
        return mutableListOf(PetStoreDetails::class, PetStoreFindByStatusCall::class, Done::class)
    }

    override fun description() = "GET /pet/{petId}"
}
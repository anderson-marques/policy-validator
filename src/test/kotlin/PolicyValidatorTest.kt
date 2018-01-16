import org.junit.Test
import javax.json.Json
import javax.json.JsonObject
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse

class PolicyValidatorTest {

    @Test
    fun testPolicyWithoutActionShouldThrowsInvalidPolicyException() {
        assertFailsWith(InvalidPolicyException::class) {
            val policy: JsonObject = Json.createObjectBuilder().build()
            validatePolicy(policy)
        }
    }

    @Test
    fun testPolicyWithActionAllowShoudNotReturnFalse(){
        assertFalse {
            val policy : JsonObject = Json.createObjectBuilder().add("action",  "allow").build()
            validatePolicy(policy = policy)
        }
    }
}


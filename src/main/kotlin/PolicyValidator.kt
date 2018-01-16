import javax.json.JsonObject

/**
 * Validates a policy in JsonObject format
 */
fun validatePolicy(policy: JsonObject) : Boolean {
    var authorize = false

    val action = policy.getString("action", "undefined")

    if (action == "undefined") throw InvalidPolicyException()

    if (action == "allow") {
        authorize = false
    }

    return authorize;
}
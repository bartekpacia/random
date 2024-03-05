app_id = "com.example_app"
name = "Sign in & order food"
tags = [
    "nightly-build",
    "pull-request",
]

env = {
    "USERNAME": "user@example.com",
    "PASSWORD": "testpass",
}

def on_flow_start():
    pass

def on_flow_complete():
    print("Ho ho ho!")

def flow():
    launch_app(
        clear_state = True,
        permissions = {"all": "deny"},
    )
    set_location(37.80783, -122.47527)
    tap_on(
        id = "login__email",
    )
    input_text(env.USERNAME)
    tap_on(
        id = "login__password",
    )
    input_text(env.PASSWORD)
    assert_visible(
        text = "Welcome back, Jo 👋!",
        id = "home__welcome_msg",
    )

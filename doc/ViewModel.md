# UI Events as State

Events are used int states with [consume event library](https://github.com/leonard-palm/compose-state-events)

Define events in state data class like the following;
```kotlin
data class TestState(
    val singleEvent: StateEvent = consumed,
    val singleEventWithContent: StateEventWithContent<Int> = consumed(),
) : IViewState
```

Events are initially defined as `consumed` or `consumed()` if it has content.
In order to fire the event you need the set its state as `triggered` or if it has content pass the content with `triggered()`
You can do it in the view model as the following;

```kotlin
class TestViewModel : BaseViewModel<TestState>() {
    override fun createInitialState(): TestState = TestState()
    // triggers the events
    fun fireEvent() {
        setState {
            copy(
                singleEvent = triggered,
                singleEventWithContent = triggered(42)
            )
        }
    }

    // consume single event
    fun onConsumeSingleEvent() {
        setState { copy(downloadSucceededEvent = consumed) }
    }

    // consume single event with content
    fun onConsumeSingleEventWithContent() {
        setState { copy(downloadFailedEvent = consumed()) }
    }
}
```

In the Composable function consume events with `EventEffect` side effect.

```kotlin
@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    viewModel: TextViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    EventEffect(
        event = uiState.singleEvent,
        onConsumed = viewModel::onConsumeSingleEvent
    ) {
        // take the action as you like
    }

    EventEffect(
        event = uiState.singleEventWithContent,
        onConsumed = viewModel::onConsumeSingleEventWithContent
    ) { stringRes ->
        // take the action as you like
    }
    
    // ... rest of the ui
}
```
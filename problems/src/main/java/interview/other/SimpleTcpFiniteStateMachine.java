package interview.other;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class SimpleTcpFiniteStateMachine {
    String traverseTcpStates(Collection<String> actions) {

        States.CLOSED.with(new Transition(Events.APP_PASSIVE_OPEN, States.LISTEN));
        States.CLOSED.with(new Transition(Events.APP_ACTIVE_OPEN, States.SYN_SENT));
        States.LISTEN.with(new Transition(Events.RCV_SYN, States.SYN_RCVD));
        States.LISTEN.with(new Transition(Events.APP_SEND, States.SYN_SENT));
        States.LISTEN.with(new Transition(Events.APP_CLOSE, States.CLOSED));
        States.SYN_RCVD.with(new Transition(Events.APP_CLOSE, States.FIN_WAIT_1));
        States.SYN_RCVD.with(new Transition(Events.RCV_ACK, States.ESTABLISHED));
        States.SYN_SENT.with(new Transition(Events.RCV_SYN, States.SYN_RCVD));
        States.SYN_SENT.with(new Transition(Events.RCV_SYN_ACK, States.ESTABLISHED));
        States.SYN_SENT.with(new Transition(Events.APP_CLOSE, States.CLOSED));
        States.ESTABLISHED.with(new Transition(Events.APP_CLOSE, States.FIN_WAIT_1));
        States.ESTABLISHED.with(new Transition(Events.RCV_FIN, States.CLOSE_WAIT));
        States.FIN_WAIT_1.with(new Transition(Events.RCV_FIN, States.CLOSING));
        States.FIN_WAIT_1.with(new Transition(Events.RCV_FIN_ACK, States.TIME_WAIT));
        States.FIN_WAIT_1.with(new Transition(Events.RCV_ACK, States.FIN_WAIT_2));
        States.CLOSING.with(new Transition(Events.RCV_ACK, States.TIME_WAIT));
        States.FIN_WAIT_2.with(new Transition(Events.RCV_FIN, States.TIME_WAIT));
        States.TIME_WAIT.with(new Transition(Events.APP_TIMEOUT, States.CLOSED));
        States.CLOSE_WAIT.with(new Transition(Events.APP_CLOSE, States.LAST_ACK));
        States.LAST_ACK.with(new Transition(Events.RCV_ACK, States.CLOSED));

        Automaton automaton = new Automaton(States.CLOSED);
        actions.stream()
                .map(Events::valueOf)
                .forEach(automaton::switchState);

        return automaton.current.toString();
    }

    public enum States {
        CLOSED,
        LISTEN,
        SYN_SENT,
        SYN_RCVD,
        ESTABLISHED,
        CLOSE_WAIT,
        LAST_ACK,
        FIN_WAIT_1,
        FIN_WAIT_2,
        CLOSING,
        TIME_WAIT,
        ERROR;

        private List<Transition> transitions;

        States() {
            this.transitions = new ArrayList<>();
        }

        /**
         * Follow one of the transitions, to get to the next state.
         * @param event an event.
         * @return a state or ERROR state if this transition is not possible.
         */
        public States transit(final Events event) {
            return transitions
                    .stream()
                    .filter(t -> t.isPossible(event))
                    .map(Transition::state)
                    .findAny()
                    .orElse(ERROR);
        }

        public States with(Transition tr) {
            this.transitions.add(tr);
            return this;
        }
    }

    public enum Events {
        APP_PASSIVE_OPEN,
        APP_ACTIVE_OPEN,
        APP_SEND,
        APP_CLOSE,
        APP_TIMEOUT,
        RCV_SYN,
        RCV_ACK,
        RCV_SYN_ACK,
        RCV_FIN,
        RCV_FIN_ACK
    }

    static class Automaton {

        private States current;

        /**
         * Ctor.
         * @param initial Initial state of this machine.
         */
        Automaton(final States initial) {
            this.current = initial;
        }

        /**
         * Follow a transition, switch the state of the machine.
         * @param event and event.
         */
        void switchState(final Events event) {
            current = this.current.transit(event);
        }
    }

    static class Transition {

        private final Events event;
        private final States next;

        Transition(final Events event, final States next) {
            this.event = event;
            this.next = next;
        }

        States state() {
            return this.next;
        }

        boolean isPossible(Events event) {
            return this.event.equals(event);
        }
    }
}

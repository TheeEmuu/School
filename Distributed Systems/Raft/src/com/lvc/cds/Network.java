package com.lvc.cds;

import com.google.protobuf.Message;

import com.lvc.cds.RaftProtos.AppendEntries;
import com.lvc.cds.RaftProtos.RequestVote;
import com.lvc.cds.RaftProtos.AppendEntriesResponse;
import com.lvc.cds.RaftProtos.RequestVoteResponse;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Network {
    private ConcurrentLinkedQueue<Message> inbound;
    private BlockingQueue<Message> outbound;

    public void sendAppendEntries(int term, RaftNode node, RaftNode.Entry[] entries) {
        // assemble a Message object.
        // put it in the queue, return immediately
        AppendEntries.Builder message = AppendEntries.newBuilder();
        message.setTerm(term);
        message.setLeaderId(node.getLeaderId());
        message.setPreviousLogIndex(node.getLastApplied());
        message.setPreviousLogTerm(node.getLog().get(node.getLastApplied()).term);
        for (RaftNode.Entry entry : entries) {
            message.addEntry(entry.entry);
        }
        message.setLeaderCommit(node.getCommitIndex());
        outbound.add(message.build());
    }

    public void sendRequestVotes(int term) {
        // assemble a Message object.
        // put it in the queue, return immediately

    }

    public void sendRequestVotesReply(int term) {
        // assemble a Message object.
        // put it in the queue, return immediately

    }

    public void sendAppendEntriesReply(int term) {
        // assemble a Message object.
        // put it in the queue, return immediately

    }

    public Message getIncomingMessage() {
        // pop something off the incoming queue, return it.
        return inbound.poll();
    }

    private void outgoing() {
        // some setup code.
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // check to see if the queue has any messages in it
                    // if so, pop them out, send them
                }
            }
        });
        th.start();
    }

    private void incoming() {
        // some setup code
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                // make a listening socket
                while (true) {
                    // accept a connection

                    // handle the connection by reading the byte
                    // stream, converting to a protobuf message,
                    // converting to some other object (a Message
                    // again?), then pushing onto the queue.
                }

            }
        });
        th.start();
    }
}

package com.example.self_chat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MessageRecyclerUtils {
    static class MessageCallback extends DiffUtil.ItemCallback<Message> {

        @Override
        public boolean areItemsTheSame(@NonNull Message m1, @NonNull Message m2) {
            return m1.getText().equals(m2.getText());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Message m1, @NonNull Message m2) {
            return m1.equals(m2);
        }
    }


    interface SendClickCallback {
        void onSendClick(Message msg);
    }

    static class MessageAdapter extends ListAdapter<Message, MessageHolder> {

        public MessageAdapter() {
            super(new MessageCallback());
        }

        @NonNull @Override
        public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int itemType) {
            final Context context = parent.getContext();

            View itemView = LayoutInflater.from(context)
                            .inflate(R.layout.item_one_message, parent, false);

            return new MessageHolder(itemView);

        }

        @Override
        public void onBindViewHolder(@NonNull MessageHolder personHolder, int position) {
            Message msg = getItem(position);
            personHolder.text.setText(msg.getText());
        }
    }

    static class MessageHolder extends RecyclerView.ViewHolder {
        public final TextView text;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.message_text);
        }
    }
}

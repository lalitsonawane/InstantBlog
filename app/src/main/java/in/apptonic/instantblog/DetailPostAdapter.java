package in.apptonic.instantblog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.apptonic.instantblog.model.Post;

/**
 * Created by lalitkumarsonawane on 26/11/17.
 */

public class DetailPostAdapter extends RecyclerView.Adapter<DetailPostAdapter.ViewHolder>{

    private List<Post> post = new ArrayList<>();
    private Context context;

    public DetailPostAdapter(){}

    public DetailPostAdapter(Context context, List<Post> post) {
        this.post = post;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTitle.setText(post.get(position).getTitle_post());
        holder.mShort_desc.setText(post.get(position).getShort_desc());
        holder.mDetail_view.setText(post.get(position).getDetail_post());

    }

    @Override
    public int getItemCount() {
        return post.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mShort_desc;
        TextView mDetail_view;

        public ViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.title);
            mShort_desc = itemView.findViewById(R.id.short_description);
            mDetail_view = itemView.findViewById(R.id.detail_post);
        }
    }
}

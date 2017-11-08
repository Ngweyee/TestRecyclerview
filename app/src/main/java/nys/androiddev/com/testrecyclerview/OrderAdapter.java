package nys.androiddev.com.testrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nys.androiddev.com.testrecyclerview.views.FastScrollRecyclerView;

/**
 * Created by ngweyeeshoon on 11/8/17.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>
        implements FastScrollRecyclerView.SectionedAdapter,
        FastScrollRecyclerView.MeasurableAdapter{

    private Context context;
    private List<String> orderlist;

    private static final int REGULAR_ITEM = 0;
    private static final int TALL_ITEM = 1;



    public OrderAdapter(Context context, List<String> orderlist) {

        this.context = context;
        this.orderlist = orderlist;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        @LayoutRes int viewId;
         if(viewType == TALL_ITEM){
             viewId = R.layout.tall_item;
         }else {
             viewId = R.layout.item;
         }

         View view = LayoutInflater.from(context).inflate(R.layout.tall_item,parent,false);
        return new OrderViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        holder.textView.setText(String.format("Item %d", position));
    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        return String.valueOf(position);
    }

    @Override
    public int getViewTypeHeight(RecyclerView recyclerView, int viewType) {
        if (viewType == REGULAR_ITEM) {
            return recyclerView.getResources().getDimensionPixelSize(R.dimen.list_item_height);
        } else if (viewType == TALL_ITEM) {
            return recyclerView.getResources().getDimensionPixelSize(R.dimen.list_item_tall_height);
        }
        return recyclerView.getResources().getDimensionPixelSize(R.dimen.list_item_tall_height);

    }


    @Override
    public int getItemViewType(int position) {
        if (position > 100) {
            return TALL_ITEM;
        }
        return TALL_ITEM;

    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public OrderViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);

        }
    }
}

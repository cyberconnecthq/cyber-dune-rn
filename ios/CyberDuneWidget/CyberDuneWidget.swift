//
//  CyberDuneWidget.swift
//  CyberDuneWidget
//
//  Created by spantar on 2024/6/1.
//

import WidgetKit
import SwiftUI

struct Provider: TimelineProvider {
  func placeholder(in context: Context) -> SimpleEntry {
    SimpleEntry(date: Date(), totalStakedCyber: 4404656)
  }
  
  func getSnapshot(in context: Context, completion: @escaping (SimpleEntry) -> ()) {
    let entry = SimpleEntry(date: Date(), totalStakedCyber: 4404656)
    completion(entry)
  }
  
  func getTimeline(in context: Context, completion: @escaping (Timeline<Entry>) -> ()) {
    var entries: [SimpleEntry] = []
    
    // Generate a timeline consisting of five entries an hour apart, starting from the current date.
    let currentDate = Date()
    for minuteOffset in 0 ..< 24 {
      let entryDate = Calendar.current.date(byAdding: .minute, value: minuteOffset, to: currentDate)!
      let entry = SimpleEntry(date: Date(), totalStakedCyber: 4404656 + minuteOffset*100)
      entries.append(entry)
    }
    
    let timeline = Timeline(entries: entries, policy: .atEnd)
    completion(timeline)
  }
}

struct SimpleEntry: TimelineEntry {
  let date: Date
  let totalStakedCyber: Int
}

struct CyberDuneWidgetEntryView : View {
  var entry: Provider.Entry
  @Environment(\.widgetFamily) var family // 尺寸环境变量
  
  var body: some View {
    switch family {
    case .systemSmall:
      ZStack{
        Image("cyber_logo")
          .resizable()
          .frame(maxWidth: .infinity, maxHeight: .infinity)
          .opacity(0.5)
        VStack() {
          Text("9.8$")//↑↓
            .foregroundColor(Color.black)
            .font(Font.system(size: 18, weight: .semibold))
          +
          Text("↑")
            .foregroundColor(Color.green)
            .font(Font.system(size: 22, weight: .bold))
        }
      }
    case .systemMedium:
      HStack{
        VStack(alignment:.leading){
          Image("cyber_logo_full")
            .resizable()
            .frame(width: 88, height: 287/795 * 88)
          Spacer().frame(height: 12)
          Text("GasFee: ")
            .foregroundColor(Color.black)
            .font(Font.system(size: 12))
          +
          Text("6.43 Gwei")
            .foregroundColor(Color.black)
            .font(Font.system(size: 14, weight: .bold))
          Spacer().frame(height: 12)
          Text("Cyber Price: ")
            .foregroundColor(Color.black)
            .font(Font.system(size: 12))
          +
          Text("9.5$")
            .foregroundColor(Color.black)
            .font(Font.system(size: 14, weight: .bold))
        }
        .padding(.leading, 12)
        Spacer().frame(width: 12)
        VStack(alignment:.leading){
          HStack{
            
            HStack{
              Spacer().frame(width: 8)
              Image("profile")
                .resizable()
                .frame(width: 14, height: 14)
              Text("Profile")
                .font(Font.system(size: 14, weight: .bold))
                .foregroundColor(Color.black)
              Spacer()
            }
            .frame(width: 99, height: 30)
            .overlay {
              RoundedRectangle(cornerRadius: 8)
                .stroke(Color(.green), lineWidth: 1.0)
            }
            
            Spacer().frame(width: 12)
            HStack{
              Spacer().frame(width: 8)
              Image("transfer")
                .resizable()
                .frame(width: 14, height: 14)
              Text("Transfer")
                .font(Font.system(size: 14, weight: .bold))
                .foregroundColor(Color.black)
              Spacer()
            }
            .frame(width: 99, height: 30)
            .overlay {
              RoundedRectangle(cornerRadius: 8)
                .stroke(Color(.green), lineWidth: 1.0)
            }
            Spacer()
          }
          
          Spacer().frame(height: 16)
          
          HStack{
            HStack{
              Spacer().frame(width: 8)
              Image("qrcode")
                .resizable()
                .frame(width: 12, height: 12)
              Text("QR Code")
                .font(Font.system(size: 14, weight: .bold))
                .foregroundColor(Color.black)
              Spacer()
            }
            .frame(width: 99, height: 30)
            .overlay {
              RoundedRectangle(cornerRadius: 8)
                .stroke(Color(.green), lineWidth: 1.0)
            }
            Spacer().frame(width: 12)
            HStack{
              Spacer().frame(width: 8)
              Image("scan")
                .resizable()
                .frame(width: 14, height: 14)
              Text("Scan")
                .font(Font.system(size: 14, weight: .bold))
                .foregroundColor(Color.black)
              Spacer()
            }
            .frame(width: 99, height: 30)
            .overlay {
              RoundedRectangle(cornerRadius: 8)
                .stroke(Color(.green), lineWidth: 1.0)
            }

          }
        }
        Spacer()
      }
      .padding(.all, 8)
      
    default:
      VStack(alignment:.leading) {
        Text(entry.date, style: .time)
          .font(Font.system(size: 14, weight: .bold))
          .foregroundColor(Color.black)
        HStack{
          Text("Total Staked CYBER: ")
            .font(Font.system(size: 14, weight: .bold))
            .foregroundColor(Color.black)
          Text(String(entry.totalStakedCyber))
            .font(Font.system(size: 14, weight: .bold))
            .foregroundColor(Color.black)
        }
      }
    }
  }
}

struct CyberDuneWidget: Widget {
  let kind: String = "CyberDuneWidget"
  
  var body: some WidgetConfiguration {
    StaticConfiguration(kind: kind, provider: Provider()) { entry in
      if #available(iOS 17.0, *) {
        CyberDuneWidgetEntryView(entry: entry)
          .containerBackground(Color(.white), for: .widget)
      } else {
        CyberDuneWidgetEntryView(entry: entry)
          .padding()
          .background(Color(.white))
      }
    }
    .configurationDisplayName("My Widget")
    .description("This is an example widget.")
    .supportedFamilies([.systemSmall,.systemMedium])
  }
}

struct DoubleBorderStackStyle: ViewModifier {
    let innerColor: Color
    let outerColor: Color
    let borderWidth1: CGFloat
    let borderWidth2: CGFloat
    let cornerRadius: CGFloat

    func body(content: Content) -> some View {
        content
            .padding(2)
            .background(
                RoundedRectangle(cornerRadius: cornerRadius)
                    .stroke(outerColor, lineWidth: borderWidth2)
                    .background(
                        RoundedRectangle(cornerRadius: cornerRadius)
                            .stroke(innerColor, lineWidth: borderWidth1)
                            .padding(1)
                    )
            )
    }
}

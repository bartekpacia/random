#import <Foundation/Foundation.h>
#import "Delegate.h"

// compile with:
// clang -o main main.m Delegate.m peertalk/PTChannel.m peertalk/PTProtocol.m peertalk/PTUSBHub.m -framework Foundation

@implementation Delegate
- (void)doSomething:(NSString*)data {
    NSLog(@"Okay, doing something with %@", data);
}

- (void)connectToUSBDevice {
  PTChannel *channel = [PTChannel channelWithDelegate:self];
  channel.userInfo = connectingToDeviceID_;
  channel.delegate = self;
  
  [channel connectToPort:PTExampleProtocolIPv4PortNumber overUSBHub:PTUSBHub.sharedHub deviceID:connectingToDeviceID_ callback:^(NSError *error) {
    if (error) {
      if (error.domain == PTUSBHubErrorDomain && error.code == PTUSBHubErrorConnectionRefused) {
        NSLog(@"Failed to connect to device #%@: %@", channel.userInfo, error);
      } else {
        NSLog(@"Failed to connect to device #%@: %@", channel.userInfo, error);
      }
      if (channel.userInfo == self->connectingToDeviceID_) {
        [self performSelector:@selector(enqueueConnectToUSBDevice) withObject:nil afterDelay:PTAppReconnectDelay];
      }
    } else {
			self->connectedDeviceID_ = self->connectingToDeviceID_;
      self.connectedChannel = channel;
    }
  }];
}

@end

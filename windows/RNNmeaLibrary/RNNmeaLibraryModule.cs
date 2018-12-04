using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Nmea.Library.RNNmeaLibrary
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNNmeaLibraryModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNNmeaLibraryModule"/>.
        /// </summary>
        internal RNNmeaLibraryModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNNmeaLibrary";
            }
        }
    }
}
